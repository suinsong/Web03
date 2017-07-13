$(document).ready(function(){
	mlist();
	$("#btn").click(mInsert);
	
});
function mInsert(){
	 var fdata = $("#frm").serialize();
	$.ajax({
		url: "mInsert.do", //MemberInsertController.java
		type: "post",
		data: fdata,
		success : mlist,
		error : function(){ alert("저장실패");  }
	});
	
}

function mlist(){
	$("#rebtn").trigger("click");
	$.ajax({
		url : "mlist.do",
		type : "get",
		datatype : "json",
		success : resultHtml, // callback함수
		error : function(){	alert("error");	}
	});
}

function resultHtml(data){
	var html="<table  width='800px' >";
	html+="<tr bgColor='pink' color='white' align='center'>";
	html+="<td><b>번호</b></td>";
	html+="<td><b>이름</b></td>";
	html+="<td><b>나이</b></td>";
	html+="<td><b>이메일</b></td>";
	html+="<td><b>자기소개</b></td>";
	html+="<td><b>삭제</b></td>";
	html+="<td><b>수정</b></td>";
	html+="</tr>";
	
	$.each(data, function(index,obj){
		html+="<tr>";
		html+="<td id='num"+index+"'>"+obj.num+"</td>";
		html+="<td id='irum"+index+"'>"+obj.irum+"</td>";
		html+="<td id='age"+index+"'>"+obj.age+"</td>";
		html+="<td id='email"+index+"'>"+obj.email+"</td>";
		html+="<td id='intro"+index+"'>"+obj.intro+"</td>";
		html+="<td><button onClick='mDelete("+obj.num+")'>삭제</button></td>";
		html+="<td><button onClick='mUpdate("+index+")'>수정</button></td>";
		html+="</tr>";
		
	});
	
	html+="</table>";
	$("#msg").empty();
	$("#msg").append(html);
}

function mUpdate(index){
	var num=$("#num"+index).text();
	var irum=$("#irum"+index).text();
	var age=$("#age"+index).text();
	var email=$("#email"+index).text();
	var intro=$("#intro"+index).text();
	
	//alert(num+":"+intro);
	$("#num").val(num);
	$("#age").val(age);
	$("#email").val(email);
	$("#intro").val(intro);
	$("#inup").empty();
	$("#inup").append("<input type='button' value='수정' id='upbtn'/>");
	$("#upbtn").click(mUpdateGo);
}


function mUpdateGo(){
	var fdata =$("#frm").serialize();
	//alert(fdata);
	
	$.ajax({
		url : "mUpdate.do",
		type : "post",
		data : fdata,
		success : mlist,
		error : function(){ alert("error");}
				
	})
		$("#inup").empty();
		$("#inup").html("<input type='button' value='가입' id='btn'/>");
		$("#upbtn").click(mInsert);
		$("#rebtn").trigger("click");
	
}

function mDelete(num){
	// alert(num);
	$.ajax({
		url:"mDelete.do",
		type:"get",
		data: {"num":num},
		success : mlist,
		error : function(){ alert("error");}
	
	});
	

}
