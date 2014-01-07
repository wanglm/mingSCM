//公用的JS文件
//用户退出
function fExit() {
	var data = {
		isExit : 'exit'
	};
	$.post('LoginAction', data, function(json) {
		if (json.success) {
			location.href = "/myWeb";
		}
	});
}

	// 删除一行记录
	function fDelete(id) {
		var data = {
			id : id,
			actionType : 'delete'
		};
		if (confirm("确认要删除这条信息吗？")) {
			$.post('UserAction', data, function(json) {
				if (json.success) {
					$('#tr_' + id).remove();
				} else {
					alert('删除失败！');
				}
			});
		}
	}
