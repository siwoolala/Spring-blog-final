let index = {
	init: function() {
		$("#btn-save").on("click", () => {
			this.save();
		});
		/*
		$("#btn-login").on("click", () => {
			this.login();
		});
		*/
	},

	save: function() {
		//alert('user의 save 함수 호출 됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
			email: $("#email").val()
		};
			alert("회원가입 버튼 클릭함");
			console.log("회원가입 버튼 클릭함")
		//console.log(data);

		$.ajax({
			type: "POST",
			url: "/auth/joinProc",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			/*alert("resp : " + resp);*/
			alert("회원가입이 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	}



	/*
	login: function() {
		//alert('user의 save 함수 호출 됨');
		let data = {
			username: $("#username").val(),
			password: $("#password").val(),
		};

		//console.log(data);

		$.ajax({
			type: "POST",
			url: "/api/user/login",
			data: JSON.stringify(data),
			contentType: "application/json; charset=utf-8",
			dataType: "json"
		}).done(function(resp) {
			alert("로그인 완료되었습니다.");
			location.href = "/";
		}).fail(function(error) {
			alert(JSON.stringify(error));
		}); //ajax 통신을 이용해서 3개의 데이터를 json으로 변경하여 insert 요청!
	}
	*/

}

index.init();