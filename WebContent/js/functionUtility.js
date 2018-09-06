
function caricaNuoveUscite(){
	
	console.log("sono nel load");
	//$(".albums").html("");
	
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'ultimeuscite'
					
			},
    success: function (data) {
    	console.log("sono in success");
    	console.log(data);
    	for(var i=0; i<data.length;i++){
    		$(".albums").append('<div class="col-md-3 content-grid">'+
										'<a class="play-icon popup-with-zoom-anim" href="#small-dialog"><img src="'+data[i]["linkImg"]+'" title="allbum-name"></a>'+
										'<a class="button play-icon popup-with-zoom-anim" href="#" onclick="PlayBrano('+data[i]["idBrano"]+');">'+data[i]["titolo"]+'</a><div class="inner-info"><h5>'+data[i]["genere"]+'</h5></div>'+
										'</div>'
    			);
    		console.log(data[i]["linkImg"]);
    	}
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });//ajax
	
}

function afterLogin(){
	
	$("#sb-search").show();
	console.log("sono in afterlogin");
	//$(".albums").html("");
	
}

function Playbrano(idbrano){
	
	console.log("sono nel load");
	//$(".albums").html("");
	
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'addascolto',
					"brano" : 'idbrano'
			
					
			},
    success: function (data) {
    	console.log("sono in playbrano");
    	
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });//ajax
	
}
