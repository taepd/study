package DI_06_Spring;

public class HelloApp {

	public static void main(String[] args) {
		//insert 작업
		//Oracle 사용
		//OracleArticleDao articledao = new OracleArticleDao();
		MySqlArticleDao articledao = new MySqlArticleDao();
		ArticleService articleservice = new ArticleService(articledao);
		
		Article article = new Article();
		articleservice.write(article);

	}

}
