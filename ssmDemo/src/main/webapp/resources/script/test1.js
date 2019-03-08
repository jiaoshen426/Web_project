/**
 * 
 */ var data1 = {
				"name": "jiaoshen",
				"account" : "asd"
				
			};
			
			$.ajax({
						type : "POST",
						url : "receive/receive6.do",
						data : data1,
						dataType : "json",
						success : function(data) {
							alert(data);
						},
						error : function(data) {
							alert("error")
						}
			 });
	        	var json1 = {
				"account" : ["imp","newimp"],
				"age" : 99
			};