

function showHello() 
{ 
	var date = new Date();
	
	var hello = "";
	var hour = date.getHours();
	if ( hour >= 0 && hour < 3 ) {
		hello = "凌晨啦, 早点休息哦";
	} else if ( hour >= 3 && hour < 9 ) {
		hello = "早上好";
	} else if ( hour >= 9 && hour < 12 ) {
		hello = "上午好";
	} else if ( hour >= 12 && hour < 18 ) {
		hello = "下午好";
	} else if ( hour >= 18 && hour < 24 ) {
		hello = "晚上好";
	}
	
	$("#hello").text(hello); 
} 

function doProcess(url) {
    $.getJSON(url ,
        function(data){
            data = data.ajaxInfoModel;
            if(data.status=='n'){
                alert(data.info);
            }else {
                window.location.href=window.location.href;
            }
        }
    );
}

//将一个表单的数据返回成JSON对象   
$.fn.serializeObject = function() {   
  var o = {};   
  var a = this.serializeArray();   
  $.each(a, function() {   
    if (o[this.name]) {   
      if (!o[this.name].push) {   
        o[this.name] = [ o[this.name] ];   
      }   
      o[this.name].push(this.value || '');   
    } else {   
      o[this.name] = this.value || '';   
    }   
  });   
  return o;   
};   
