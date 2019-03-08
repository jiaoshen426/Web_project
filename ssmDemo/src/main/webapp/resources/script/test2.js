/**
 * 
 */
$(document).ready(function() {


	var data1 = [{
		"name" : "jiaoshen",
		"account" : {
			id : 12,
			cardId : "kk"
		},
		"map1" :{
			"add" :"123",
			"phone" : "12375454"
		}

	}];
	$.ajax({
				type : "POST",
				contentType : 'application/json;charset=utf-8',
				url : "receive/receive6.do",
				data : JSON.stringify(data1),
				dataType : "json",
				success : function(data) {
					alert(data);
				},
				error : function(data) {
					alert("error")
				}
			});
		//	
		// 基本数据交互
		// $.ajax({
		// type : "POST",
		// url : "receive/receive6.do",
		// data:{name:"imp",age:"22"},
		// dataType : "json",
		// success : function(data) {
		// alert(data);
		// },
		// error: function(data){
		// alert("error")
		// }
		// });

		// var users = JSON.stringify([{
		// name : "wabiaozai1",
		// pwd : "123"
		// }, {
		// name : "wabiaozai2",
		// pwd : "123"
		// }]);
		// var newusers = JSON.stringify({
		// name : "jiaoshen",
		// kkk: "asd",
		// accounts:[{id : 1,
		// cardId :"12342352",
		// balance :"8912836.2"
		// },{id : 2,
		// cardId :"222222",
		// balance :"222222.2"
		// }]
		// });
		//					
		//					
		// $.ajax({
		// type : "post",
		// url : "receive/wabiaozai.do",
		// data : newusers,
		// contentType : "application/json; charset=utf-8",
		// dataType : "json",
		// success : function(response, ifo) {
		// alert("success");
		// },
		// error : function() {
		// alert("error");
		// }
		// })
	});