<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="vi" style="height: 100%" class="mdl-js">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tạo thông tin đăng bán sách</title>
<link rel="stylesheet" href="css/update-style.css">
<style>
.cell-lblLftFldDiv input {
	border: 1px solid black;
	padding: 5px;
}
</style>
</head>

<body class="ds3 edp-crnew hd-min  full-page " style="height: 100%"
	id="body">
	<div class="pagewidth">
		<div class="pageminwidth">
			<div class="pagelayout">
				<div class="pagecontainer">
					<div class="CentralArea" id="CentralArea">
						<div class="edp sngl" id="editpane">
							<div class="main-area">
								<div id="editpane_cnt" class="cnt">
									<div class="crnew-hd">
										<br />
										<h1 class="fl-none">Tạo thông tin đăng bán sách</h1>
									</div>
									<div id="editpane_cnta">
										<form id="editpane_form" action="TaoPhienDauGia" method="post"
											enctype="multipart/form-data">
											<div class="inner-cnt" style="visibility: visible">
												<input type="hidden" id="isRestricted" value="false">
												<div class="hgh">
													<h2 class="fl-none sec-t">Chi tiết sản phẩm</h2>
													<div>
														<input type="hidden" id="isRestricted" value="false">
														<div class="def min" id="editpaneSect_Title" sec="1">
															<h2 class="reqd pad-t8">
																<label for="editpane_title">Tiêu đề</label>
															</h2>
															<div id="editpane_titlewrap">
																<input type="text" id="editpane_title" fnk="tt"
																	maxlength="30" name="title"
																	aria-describedby="titCount err_editpane_title editpane_title_toolTip"
																	aria-required="true" value="" required="required">
															</div>
														</div>
														<div class="def min" id="editpaneSect_Subtitle" sec="1">
															<h2 class="pad-t8">
																<label for="editpane_subtitle">Thể Loại</label>
															</h2>
															<div>
																<input type="checkbox" id="editpane_subtitle"
																	name="theloai1" value="1"> <label
																	for="vehicle1">Sách Tiếng Việt </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai2"
																	value="2"> <label for="vehicle1">Sách
																	văn học </label> <input type="checkbox" id="editpane_subtitle"
																	name="theloai3" value="3"> <label
																	for="vehicle1">Sách kinh tế </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai4"
																	value="4"> <label for="vehicle1">Sách
																	thiếu nhi </label> <input type="checkbox"
																	id="editpane_subtitle" name="theloai5" value="5">
																<label for="vehicle1">Sách kỹ năng sống </label> <br>
																<input type="checkbox" id="editpane_subtitle"
																	name="theloai6" value="6"> <label
																	for="vehicle1">Sách Bà mẹ - Em bé </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai7"
																	value="7"> <label for="vehicle1">Sách
																	Giáo Khoa - Giáo Trình </label> <input type="checkbox"
																	id="editpane_subtitle" name="theloai8" value="8">
																<label for="vehicle1">Sách Học Ngoại Ngữ </label> <br>
																<input type="checkbox" id="editpane_subtitle"
																	name="theloai9" value="9"> <label
																	for="vehicle1">Sách Tham Khảo </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai10"
																	value="10"> <label for="vehicle1">Từ
																	Điển </label> <input type="checkbox" id="editpane_subtitle"
																	name="theloai11" value="11"> <label
																	for="vehicle1">Sách Kiến Thức Tổng Hợp </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai12"
																	value="12"> <label for="vehicle1">Sách
																	Khoa Học - Kỹ Thuật </label> <br> <input type="checkbox"
																	id="editpane_subtitle" name="theloai13" value="13">
																<label for="vehicle1">Sách Lịch sử </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai14"
																	value="14"> <label for="vehicle1">Điện
																	Ảnh - Nhạc - Họa </label> <input type="checkbox"
																	id="editpane_subtitle" name="theloai15" value="15">
																<label for="vehicle1">Truyện Tranh, Manga, Comic
																</label> <br> <input type="checkbox" id="editpane_subtitle"
																	name="theloai16" value="16"> <label
																	for="vehicle1">Sách Tôn Giáo - Tâm Linh </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai17"
																	value="17"> <label for="vehicle1">Sách
																	Văn Hóa - Địa Lý - Du Lịch </label> <input type="checkbox"
																	id="editpane_subtitle" name="theloai18" value="18">
																<label for="vehicle1">Sách Chính Trị - Pháp Lý </label>
																<br> <input type="checkbox" id="editpane_subtitle"
																	name="theloai19" value="19"> <label
																	for="vehicle1">Sách Nông - Lâm - Ngư Nghiệp </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai20"
																	value="20"> <label for="vehicle1">Sách
																	Công Nghệ Thông Tin </label> <input type="checkbox"
																	id="editpane_subtitle" name="theloai21" value="21">
																<label for="vehicle1">Sách Y Học </label> <br> <input
																	type="checkbox" id="editpane_subtitle" name="theloai22"
																	value="22"> <label for="vehicle1">Tạp
																	Chí - Catalogue </label> <input type="checkbox"
																	id="editpane_subtitle" name="theloai23" value="23">
																<label for="vehicle1">Sách Tâm lý - Giới tính </label> <input
																	type="checkbox" id="editpane_subtitle" name="theloai24"
																	value="24"> <label for="vehicle1">Sách
																	Thường Thức - Gia Đình </label> <br> <input
																	type="checkbox" id="editpane_subtitle" name="theloai25"
																	value="25"> <label for="vehicle1">Thể
																	Dục - Thể Thao </label> <input type="checkbox"
																	id="editpane_subtitle" name="theloai26" value="26">
																<label for="vehicle1">Sách Tiếng Anh </label>
															</div>
														</div>
														<div class="sec-msk msk-con" id="editpaneSect_Condition"
															sec="1">
															<div class="def" id="editpane_cond" target="1">
																<h2 class="reqd pad-t8">
																	<strong>Tình trạng</strong>
																</h2>
																<div class="ecoli-wrap incnt">
																	<div class="combo">
																		<div id="l_itemCondition"></div>
																		<div class="cell-lblLftFldDiv">
																			<span id="e_itemCondition"> <select
																				id="itemCondition" name="TinhTrang"
																				aria-required="true" fieldname="itemCondition"
																				md="dt|INTEGER||em|Please enter a condition.||ev|-1"
																				title="Condition"
																				aria-describedby="err_itemCondition editpane_condition_toolTip"
																				vld="1" fn="cond">
																					<option value="Sách Mới 100%" selected="selected">Sách
																						Mới 100%</option>
																					<option value="Gần Như Mới">Gần Như Mới</option>
																					<option value="Bình Thường">Bình Thường</option>
																					<option value="Hơi Cũ">Hơi Cũ</option>
																					<option value="Cũ">Cũ</option>
																			</select></span>
																			<div id="em_itemCondition"></div>
																		</div>
																	</div>
																</div>
																<br>

																<h2 class="reqd pad-t8">
																	<strong>Tác Giả</strong>
																</h2>
																<div class="ecoli-wrap incnt">
																	<div class="combo">
																		<div id="l_itemCondition"></div>
																		<div class="cell-lblLftFldDiv">
																			<span id="tacgia"> <input
																				list="DanhSachTacGia" name="name1"> <datalist
																					id="DanhSachTacGia">
																					<option value="" selected="selected">
																					<c:forEach items="${ListTacGia }" var="o">
																						<option value="${o.getTenTacGia()}">
																					</c:forEach>
																				</datalist>
																			</span> <span id="tacgia"> <input
																				list="DanhSachTacGia" name="name2"> <datalist
																					id="DanhSachTacGia">
																					<option value="" selected="selected">
																					<c:forEach items="${ListTacGia }" var="o">
																						<option value="${o.getTenTacGia()}">
																					</c:forEach>
																				</datalist>
																			</span> <span id="tacgia"> <input
																				list="DanhSachTacGia" name="name3"> <datalist
																					id="DanhSachTacGia">
																					<option value="" selected="selected">
																					<c:forEach items="${ListTacGia }" var="o">
																						<option value="${o.getTenTacGia()}">
																					</c:forEach>
																				</datalist>
																			</span>
																			<div id="em_itemCondition"></div>
																		</div>
																	</div>
																</div>
															</div>
														</div>
														<div class="def min" id="editpaneSect_Photo" sec="1">
															<h2 class="reqd">
																<label for="editpane_photo">Up Ảnh Sách</label>
															</h2>
															<div>
																<input type="file" id="editpane_photo" fnk="stt"
																	maxlength="150" name="image1" required="required">
																<input type="file" id="editpane_photo" fnk="stt"
																maxlength="150" name="image2">
																<input type="file" id="editpane_photo" fnk="stt"
																maxlength="150" name="image3">
																<input type="file" id="editpane_photo" fnk="stt"
																maxlength="150" name="image4">
															</div>

															
														</div>
														<div class="def" id="editpaneSect_Description" sec="1">
															<h2 class="reqd">
																<strong>Mô tả mặt hàng</strong>
															</h2>
															<div id="editpane_desc">
																<div class="control-group">
																	<textarea class="form-control" rows="8" id="message"
																		placeholder="Message" required="required"
																		data-validation-required-message="Please enter your message"
																		name="MoTa"></textarea>
																	<p class="help-block text-danger"></p>
																</div>
															</div>
														</div>
														<div id="editpaneSect_AddToDescription" sec="1"></div>
													</div>
												</div>
												<div class="hgh">
													<h2 class="fl-none sec-t"="805351">Chi tiết bán hàng</h2>
													<div>
														<div id="editpaneSect_Format" sec="1">
															<div class="def">
																<div>
																	<div target="1" id="editpane_formatSec"
																		class="sec-msk msk-fr">
																		<div>
																			<div id="editpane_forDur">
																				<div class="eifd-wrap">
																					<div style="margin-top: 2px; margin-bottom: 3px">
																						<h2 class="reqd pad-t8 eifd-ttl">
																							<label for="format">Kiểu đấu giá</label>
																						</h2>
																						<div class="mr255">
																							<span class="combo-lrg"><select
																								id="LoaiPhien" name="LoaiPhien" onchange="editInput()"
																								aria-required="true">
																									<option value="1" selected="selected">Mặc
																										Định</option>
																									<option value="2">Kiểu Hà Lan</option>
																							</select></span>
																						</div>
																					</div>
																					<div class="eifd-durSec">
																						<h2 class="reqd pad-t8 eifd-ttl">
																							<label for="duration">Thời gian lên sàn</label>
																						</h2>
																						<div class="mr255">
																							<span class="combo-lrg"><select
																								name="ThoiGian" id="duration"
																								aria-describedby="err_duration" pv="Days_7"
																								aria-required="true">
																									<option value="300">5 phút</option>
																									<option value="86400">1 ngày</option>
																									<option value="259200">3 ngày</option>
																									<option value="432000">5 ngày</option>
																									<option value="604800" selected="selected">7
																										ngày</option>
																									<option value="1209600">14 ngày</option>
																									<option value="2592000">30 ngày</option>
																							</select></span>
																						</div>
																					</div>
																					<div class="eifd-durSec">
																						<div id="editpane_priceQty">
																							<h2>
																								<strong>Giá</strong>
																							</h2>
																							<div>
																								<div>
																									<div>
																										<div class="epqi-cntDiv">
																											<h2 class="epqi-cntHeader fl-none">Auction-style</h2>
																											<div>
																												<div id="l_priceQtyPrntCell"></div>
																												<div class="cell-lblLftFldDiv">
																													<div>
																														<table cellpadding="0" cellspacing="0">
																															<tbody>
																																<tr>
																																	<td>
																																		<div id="editpane_startPrice"
																																			class="epqi-syiDivField epqi-inpWidth">
																																			<div>
																																				<div id="l_startPrice">
																																					<label for="startPrice">
																																						<div class="epqi-captionSpan reqd">
																																							Giá khởi điểm</div>
																																					</label>
																																				</div>
																																				<div class="cell-lblTopFldDiv">
																																					<div style="display: inline">
																																						<span style="margin-right: 4px">$</span><input
																																							type="number" name="startPrice"
																																							id="startPrice"
																																							aria-describedby="err_startPrice"
																																							md="dt|DOUBLE||em|Please enter a starting price.||vm|Please enter a valid starting price.||gdn|priceQtyPrntCell"
																																							vld="1" max="1000000"
																																							aria-required="true"
																																							aria-labelledby="startPrice_currencySymbol"
																																							required="required" onblur="{this.startPrice}" step="0.01">
																																					</div>
																																				</div>
																																			</div>
																																			<br>
																																			<div id="minPriceDisplay" style="display: none;">
																																				<div id="l_binPrice">
																																					<label for="binPrice">
																																						<div id="minPrice2" class="epqi-captionSpan">
																																							Giá thấp nhất</div>
																																					</label>
																																				</div>
																																				
																																				<div class="cell-lblTopFldDiv">
																																					<div style="display: inline">
																																						<span id="minPrice1" style="margin-right: 4px;">$</span><input
																																							type="number" name="GiaThapNhat"
																																							id="minPrice" min=1
																																							 step="0.01">
																																					</div>
																																				</div>
																																			</div>
																																			<div class="err-lbl"
																																				id="err_startPrice"></div>
																																		</div>
																																	</td>
																																	<td>
																																		<div id="editpane_binPrice"
																																			class="epqi-syiDivField epqi-inpWidth">
																																			
																																			<div class="err-lbl"
																																				id="err_binPrice"></div>
																																			<div
																																				class="edp-ly edp-abs info-small"
																																				aria-hidden="true" ignr="1"
																																				id="binPrice_help">
																																				<i class="edp-pt"></i><i class="icn"></i>
																																				<div class="icn-mrg-sm dfon fs13">
																																					Phải ít nhất <b _istranslated="1"></b>
																																					(<span _istranslated="1"></span>nhiều
																																					hơn% so với giá khởi điểm).
																																				</div>
																																			</div>
																																		</div>
																																	</td>
																																</tr>
																															</tbody>	
																														</table>
																														
																													</div>
																												</div>
																											</div>
																											<div id="editpane_quantity" 
																												class="epqi-syiDivFieldQuantity qty epqi-inpWidth">
																												<div id ="BuocGiam" style="display: none">
																													<div id="l_quantity">
																														<label for="quantity">
																															<h2 class="epqi-captionSpan">Bước
																																Giảm</h2>
																														</label>
																													</div>
																													<div class="cell-lblTopFldDiv">
																														<div style="display: inline">
																															<label>&nbsp;&nbsp;&nbsp;Thời
																																gian giảm &nbsp;Giá Giảm</label>
																															<div class="mr255">
																																<span class="combo-lrg"><select
																																	name="ThoiGianGiam" id="duration"
																																	aria-describedby="err_duration"
																																	pv="Days_7" aria-required="true">
																																		<option value="60">1 m</option>
																																		<option value="600">10 m</option>
																																		<option value="1800">30 m</option>
																																		<option value="3600">1 h</option>
																																		<option value="10800">3 h</option>
																																		<option value="21600">6 h</option>
																																		<option value="28800"
																																			selected="selected">8 h</option>

																																</select></span> <span class="combo-lrg"><select
																																	name="GiaGiam" id="duration"
																																	aria-describedby="err_duration"
																																	pv="Days_7" aria-required="true">
																																		<option value="1" selected="selected">1</option>
																																		<option value="5">5</option>
																																		<option value="10">10</option>
																																		<option value="20">20</option>
																																		<option value="50">50</option>
																																		<option value="100">100</option>
																																		<option value="300">300</option>
																																		<option value="500">500</option>
																																		<option value="1000">1000</option>
																																</select></span>
																															</div>
																														</div>
																													</div>
																													<div class="err-lbl mr255"
																														id="err_quantity"></div>
																												</div>
																											</div>
																										</div>
																									</div>
																								</div>
																							</div>
																						</div>
																					</div>
																				</div>
																			</div>
																		</div>
																		<div class="clr"></div>
																	</div>
																</div>
																<div id="editpaneSect_CHARITY" sec="1"></div>
																<div id="editpaneSect_Payment" sec="1">
																	<div class="def" id="editpane_payment" target="1">

																	</div>
																</div>
															</div>
														</div>
													</div>
												</div>
											</div>
									</div>
								</div>

								<div>
									<div class="large-btn btn-m-r20 btn-wr" id="actionbar">
										<input type="submit" value="Đăng bán" class="pbtn"><a
											href="loadSach" role="button" aria-label="Hủy">Hủy</a>
								</form>

							</div>
						</div>
					</div>
				</div>
				<br />
			</div>
		</div>
	</div>
<script>
function editInput() {
  var x = document.getElementById("minPriceDisplay");
  var y = document.getElementById("BuocGiam");
  if (x.style.display === "none") {
	    x.style.display = "block";
	  } else {
	    x.style.display = "none";
	  }
  if (y.style.display === "none") {
	    y.style.display = "block";
	    document.getElementById("minPrice").required = true;
	  } else {
	    y.style.display = "none";
	    document.getElementById("minPrice").required = false;
	  }

}
</script>

</body>
<script>
	document.getElementById("startPrice").addEventListener('blur',(e)=> 
	{
		console.log("1");
		console.log(e.target.value);
	var start = document.getElementById("startPrice");
	var min = document.getElementById("minPrice");
	min.setAttribute("max",e.target.value);
	});
	

</script>

</html>