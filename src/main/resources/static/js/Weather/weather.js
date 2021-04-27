$(document).ready(function(){
	$("#updatetime").attr("disabled","disabled");
	$("#weather").attr("disabled","disabled");
	$("#temperature").attr("disabled","disabled");
	$("#wind").attr("disabled","disabled");
	});
	
function cityChange(cityValue){
				$.ajax({
				       type: "POST",
				       url: encodeURI("getWeatherInfo"),
				       data:{"cityValue":encodeURI(cityValue)},
				       contentType: "application/x-www-form-urlencoded; charset=utf-8",
                       async:true,
				       success: function(result){
                           var data = decodeURIComponent(result);
    	                   var data = data.replace(/\+/g, " ");
    	                   var obj = jQuery.parseJSON(data);
                           $("#updatetime").val(obj.updatetime);
                           $("#updatetime").text(obj.updatetime);
                           $("#weather").val(obj.weather);
                           $("#weather").text(obj.weather);
                           $("#temperature").val(obj.temperature);
                           $("#temperature").text(obj.temperature);
                           $("#wind").val(obj.wind);
                           $("#wind").text(obj.wind);
                           $("#updatetime").attr("disabled","disabled");
                           $("#weather").attr("disabled","disabled");
                           $("#temperature").attr("disabled","disabled");
                           $("#wind").attr("disabled","disabled");
	                   }
			         });
};