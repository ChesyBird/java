package ex08;

/*
페이지 처리를 위한 객체
*/
public class PageDto {
    // 사용자가 요청한 페이지 정보
    // 기본값 - 1 (사용자가 요청한 페이지가 없는 경우)
    private int page = 1;
    // 페이지 당 보여줄 게시물의 수
    // 기본값 : 10 (사용자가 요청한 게시물 수가 없는 경우)
    private int size = 10;
    // 게시물의 총 건수 - 쿼리로 조회한 데이터베이스의 결과
    private int totalCnt;

    // 게시물의 시작번호와 끝번호 : 데이터베이스 조회 시 사용
    // DB의 종류, 버전에 따라 사용 여부가 결정됨
    private int sNo;
    private int eNo;

    // 페이지 블럭용 필드
    // 페이지 블럭의 시작번호
    private int sPageNo = 1;
    // 페이지 블럭의 끝번호
    private int ePageNo;
    // 앞으로가기 버튼/뒤로가기 버튼
    // 필드는 타입의 기본값으로 초기화
    // boolean타입의 기본값은 false
    private boolean isPrev;
    private boolean isNext;
    // 페이지 블럭 당 보여주는 페이지의 수
    private int blockSize = 5;

    @Override
    public String toString() {
        // 페이지블럭의 시작번호부터 끝번호까지 반복문을 이용해서 반환
        String str = "";

        if(isPrev){
            str += "◀ ";
        }
        for(int i=sPageNo; i<=ePageNo; i++){
            str += i + " ";
        }
        if(isNext){
            str += " ▶";
        }


        return str;
    }

    // totalCnt : 데이터베이스에 입력된 데이터의 총 건수
    // page : 사용자가 요청한 페이지 번호
    public PageDto(int page, int totalCnt){
        this.page = page;
        this.totalCnt = totalCnt;

        // 총 99건의 데이터가 있고 요청한 페이지 번호가 2페이지라면
        // 11번부터 20번까지의 데이터를 조회하고싶다
        this.eNo = (int)(Math.ceil(totalCnt/(double)size) * page);
        this.sNo = eNo - (size - 1);
        
        System.out.println("게시물의 시작번호 : " + sNo);
        System.out.println("게시물의 끝번호 : " + eNo);


        // 페이지 네비게이션을 그리기 위해 값을 초기화
        // 2페이지를 요청한 경우 첫번째 블럭이 보여져야 함
        // 페이지의 끝번호를 구함
        ePageNo = (int)(Math.ceil(page/(double)blockSize)) * blockSize;
        sPageNo = ePageNo - (blockSize - 1);

        // prev 버튼은 시작페이지 번호가 1이 아닐때만 보여준다
        isPrev = sPageNo!=1;
        // 99/10 = 9.9 : 진짜 끝페이지 번호: 10페이지
        // next 버튼은 끝페이지 번호가 진짜끝페이지 번호보다 작으면 보여준다
        int realEpageNo = (int)(Math.ceil(totalCnt/(double)size));
        System.out.println("진짜 끝페이지 번호 : " + realEpageNo);
        
        // 진짜끝번호보다 끝번호가 더 큰 경우(비어있는 페이지가 생기는 경우) 
        ePageNo = ePageNo > realEpageNo ? realEpageNo : ePageNo;
        
        isNext = realEpageNo>ePageNo;

        System.out.println(this.toString());
    }

    public PageDto(int totalCnt){
        this(1,totalCnt);
    }



    // public static void main(String[] args) {
    //     int size = 10;
    //     int totalCnt = 99;
    //     int page = 2;
    //     // int 타입 연산결과는 int
    //     System.out.println(totalCnt/size);
    //     // 더블타입으로 형변환
    //     System.out.println(size*1.0);
    //     // Math.ceil() : 올림처리

    //     // 데이터베이스에서 데이터를 조회하기 위해서 필요한 정보
    //     // 게시물의 끝번호
    //     System.out.println((int)(Math.ceil(totalCnt/(size*1.0))*page));
    //     // 게시물의 시작번호
    //     System.out.println((int)(Math.ceil(totalCnt/(size*1.0))*page) - (size - 1));

    //     PageDto pageDto = new PageDto(6, 150);
    //     System.out.println(pageDto);
        


    // }

}
