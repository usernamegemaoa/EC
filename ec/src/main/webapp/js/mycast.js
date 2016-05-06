
$(document).ready(function(){
	$("input[name=goodCheck]").click(function(){
		var checked = $(this).attr("checked");
		var cast = $(this).parents(".cast");
		cast.find("input").each(function(){
			$(this).attr("checked",checked);
		});
	});
})


//   $(".good-btn").click(function(){
//	   $(this).parents(".cast").find(".color-btn").each(function(){
//		   $(this).prop("checked", "true");
//	   });
//	   $(this).parents(".cast").find(".size-btn").each(function(){
//		   $(this).prop("checked", "true");
//	   });
//   });
//   $(".color-btn").click(function(){
//	   $(this).parents(".color").find(".size-btn").each(function(){
//		   $(this).prop("checked", "true");
//	   });
//   });
