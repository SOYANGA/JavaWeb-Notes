//检验用户名的规则函数
function checkuserName() {
	//通过id属性获取当前input标签对象
	var divInput = document.getElementById("userName");
	var userName = divInput.value;
	//适应JS中规定的正则表达式定于规则：
	var reg = /^[a-z0-9]{4,14}$/i;
	if (!reg.test(userName)) {
		alert("用户名格式不对");
		return false;
	} else {
		return true;
	}
}