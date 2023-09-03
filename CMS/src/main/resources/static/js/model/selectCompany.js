//■社員選択MODEL画面Js
$("#searchCompany").click(function() {
	var urlArrary = location.href.split("?"); 
	
	var url = urlArrary[0] + '/searchCompany';
	$.ajax({
		type: "POST",
		url: url,
		//data: JSON.stringify(search),
		data: {name:$("#param_companyName").val()},
		dataType: 'json',
		cache: false,
		timeout: 600000,
        success: function (data) {
            var outputContent = "";
            
            outputContent='<table class="providerTable" th:if="${form != null}">'+
						  '<tr class="firstTr">'+
						  '	<th style="width:20%;text-align: center;">所属会社</th>'+
						  '	<th style="width:20%;text-align: center;">所属会社ID</th>'+
						  '	<th style="width:20%;text-align: center;">アクション</th>'+
						  '</tr>'
            $.each(data, function (index, item) {
                outputContent += '<tr><td><span>' + item.companyName + '</span></td>'
                                +'<td style="text-align: left;"><span>' + item.companyId + '</span></td>'
                                +'<td><button type="button" id="selectedButton" value="'+item.companyId+"_"+item.companyName+'" onclick="clickSelect(this);" class="btn btn-secondary" style="padding:1px;">選択</button></td></tr>';
            });
            outputContent += "</table>"
            $('#outputdivCompany').html(outputContent);
        },
        error: function (data) {
            console.log(data);
        }
	});
});


function clickSelect(obj) {
	
	//会社名＋会社ID
	var selectedVal = obj.getAttribute("value");
	var valArrary = selectedVal.split("_");
	
	//分割後の配列を一覧画面の所属会社に設定する
	$("#companyID").val(valArrary[0]);
	//分割後の配列を一覧画面の社員名に設定する
	$("#companyName").val(valArrary[1]);
	$("#closeButton").trigger("click");
    //$('#outputdiv').html("");
		
}

$("#batuButton").click(function() {
	//社員選択画面の一覧をクリアする
    //$('#outputdiv').html("");
});

$("#closeButton").click(function() {
	//社員選択画面の一覧をクリアする
    $('#outputdivCompany').html("");
});

$("#openSelectCompanyScreen").click(function() {
	//費用一覧画面の社員名を社員選択画面へ渡す
    $('#param_companyName').val($('#companyName').val());
});

