/**
 * 调用后台批量删除方法
 */
function deleteBatch(basePath) {
	$("#mainForm").attr("action",basePath + "DeleteBatch.action");
	$("#mainForm").submit();
}

/**
 * 修改当前页码，调用后台重新查询
 */
function changeCurrentPage(currentPage) {
	$("#currentPage").val(currentPage);
	$("#mainForm").submit();
}
/**
 * 修改指令
 * @param basePath
 */
function fixCommand(basePath) {
	$("#fixCommandForm").attr("action",basePath + "FixCommand.action");
	$("#fixCommandForm").submit();
}
/**
 * 添加指令
 * @param basePath
 */
function addCommand(basePath) {
	$("#addCommandForm").attr("action",basePath + "addCommand.action");
	$("#addCommandForm").submit();
}