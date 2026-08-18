package ex09.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

public class ImageCopy {

    public void copy(){
        // 파일을 읽어서 저장
        String fileName = "sample.png";
        
        // 파일 이름이 중복된 경우 -> 파일 소실의 위험이 있음
        // uuid: 중복되지 않는 값을 파일 이름 뒤에 붙여줌
        // 구분자를 이용해서 배열로 반환(파일의 이름과 확장자를 분리)
        // .으로 구분해서 [0] = 파일이름, [1] = 확장자
        String[] fileNameArr = fileName.split("\\.");
        UUID uuid = UUID.randomUUID();
        // 새로운 파일 이름 만들기
        // 기존파일명_uuid.확장자
        String newFileName = fileNameArr[0] + "_" + uuid.toString() + "." + fileNameArr[1];

        // 오늘 날짜를 기준으로 폴더를 생성
        LocalDate today = LocalDate.now();

        File f = new File("d:\\upload\\%d\\%d\\%d\\".formatted(
                                                        today.getYear(),
                                                        today.getMonthValue(),
                                                        today.getDayOfMonth()));
        // File f = new File("d:/upload/2026/08/18");
        System.out.println(f.getAbsolutePath());
        if(!f.exists()){
            // f.mkdir(); : 한개의 경로를 생성
            f.mkdirs(); // 여러개의 경로를 한번에 생성
        }

        try (FileInputStream fis = new FileInputStream(fileName);
        FileOutputStream fos = new FileOutputStream(f.getAbsolutePath() + "\\" + newFileName);) {
            
            // 1kb = 1024byte
            byte[] buffer = new byte[1024];
            int len;
            
            while ((len = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
                
            }
            
            System.out.println("이미지 복사 완료");
            
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        } catch (IOException e1) {
            e1.printStackTrace();

        }

    }

    public static void main(String[] args) {
        ImageCopy ic = new ImageCopy();

        ic.copy();

    }
}
