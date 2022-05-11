package com.cos.blog.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Board {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 제작된 DB의 넘버링을 따라간다.
	private int id; // 시퀀스, auto_increment
	
	@Column(nullable = false, length = 100)
	private String title; // 아이디
	
	@Lob
	private String content;
	
	private int count; // Enum을 쓰는게 좋다. // admin, user, manager -> 도메인(프로그래밍에서 도메인은 범위를 의미)
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="userId")
	private User user;
	
	@OneToMany(mappedBy="board", fetch=FetchType.EAGER)
	private List<Reply> reply;
	
	@CreationTimestamp // 값을 비워두고 insert해도 시간이 자동 입력
	private Timestamp createDate;
}
