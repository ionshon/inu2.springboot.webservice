package com.inu2.book.springboot.domain.posts;

import com.inu2.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동생성
@NoArgsConstructor // 롬복, 기본생성자 자동 추가 ex) public Posts(){}
@Entity // 실제 db테이블과 매칭
public class Posts extends BaseTimeEntity {

    @Id  // 해당 테이블의 PK 필드
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // PK 생성 규칙, aoto_increment
    private Long id;

    @Column(length = 500, nullable = false) // 추가옵션 가능(사이즈, 타입 변경 등)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;
    private String author;

    @Builder // 해당 클래스의 빌더 패턴 클래스 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
