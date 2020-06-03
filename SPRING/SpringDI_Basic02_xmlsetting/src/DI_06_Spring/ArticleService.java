package DI_06_Spring;

public class ArticleService {
	//사용자의 요청에 따라서
	//DAO 가 가지는 함수 호출 (CRUD)
	
	//글쓰기 서비스
	
	//목록보기 서비스
	
	//ArticleService 는 객체는 ArticleDao 객체의 의존한다 (필요해)
	private ArticleDao articledao;
	public ArticleService(ArticleDao articledao) {
			this.articledao = articledao; //articledao 객체의 주소 할당
			System.out.println("ArticleService 생성자 호출");
	}
	
	//글쓰기 서비스
	public void write(Article article) {
		this.articledao.insert(article); // DAO 객체의 insert 함수 호출
	}
}




