# album-web

部員アルバムのwebアプリ。各部員が自身のプロフィールやプライベートを記入し、他の人間が閲覧して、、コミュニケーションの一助にする。  
利用者は画面上からCRUDができる。

## 環境
Maven  
SpringBoot  
Tymeleaf  
h2  

## 起動方法

mvn spring-boot:runで実行  
URL: http://localhost:9000/album/ 

# 実装ルール

## Controller

* パッケージ  
  jp.co.tis.climate.albumweb.presentation.controller
* クラス単位  
  1HTMLに対して、1クラス。 パッケージはHTMLのパス構成に合わせる。

## Service

* パッケージ  
  jp.co.tis.climate.albumweb.application.service
* クラス単位  
  機能設計書に従う。

### 実装上の注意点

サービスメソッドの引数にはエンティティ、Dto、またはドメインの型のみ指定可能。String型などは引数には使用しないこと。  
部分一致を表すためには以下のように実装する。
```java
List<Profile> select(Partial<Name> name, Partial<Hobby> hobby);
```

## エンティティ、Dto

* パッケージ  
  jp.co.tis.climate.albumweb.domain.model  
  jp.co.tis.climate.albumweb.presentation.dto
* クラス単位  
  1テーブルにつき、1エンティティクラス。または1SQLにつき1DTO。

### 実装上の注意点

フィールドの型にはドメインクラスを指定すること。

## Form

* パッケージ  
  jp.co.tis.climate.albumweb.presentation.form
* クラス単位  
  1Formにつき、1クラス。ただし、登録と更新のように、共通化できるものは共通化してもよい。

### 実装上の注意点

フィールドの型にはすべてStringクラスを指定すること。

## 実装ガイド

### Beanコピー

Beanコピーには`BeanUtilsBean`クラスをDIして使用してください。Domain<->String型の変換ができます。  
※ 現在は`valueType = String.class`のDomainにのみ対応してます。左記以外の場合はプロパティの移動は手動で実装してください。

```java
public class SampleController {
    private final BeanUtilsBean beanUtilsBean;
    
    public PageController(BeanUtilsBean beanUtilsBean) {
        this.beanUtilsBean = beanUtilsBean;
    }

    @GetMapping("/test")
    public String test(@ModelAttribute @Validated TeamForm teamForm, Model model) throws InvocationTargetException, IllegalAccessException {
        // Formクラスをエンティティクラスにコピー
        Team team = new Team();
        beanUtilsBean.copyProperties(team, teamForm);
        return "login";
    }
}
```