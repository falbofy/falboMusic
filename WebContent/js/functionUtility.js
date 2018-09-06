
function caricaNuoveUscite(){
	
	console.log("sono nel load");
	//$(".albums").html("");
	
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'ultimiinseriti'
					
			},
    success: function (data) {
    	//console.log("sono in success");
    	//console.log(data);
    	for(var i=0; i<data.length && i<8;i++){
    		$(".albums").append('<div class="col-md-3 content-grid">'+
										'<a class="play-icon popup-with-zoom-anim" ><img src="'+data[i]["linkImg"]+'" title="allbum-name"></a>'+
										'<a class="button play-icon popup-with-zoom-anim" href="#" onclick="PlayBrano('+data[i]["idBrano"]+');">'+data[i]["titolo"]+'</a><div class="inner-info"><h5>'+data[i]["genere"]+'</h5></div>'+
										'<i class="glyphicon glyphicon-play-circle" onclick="PlayBrano('+data[i]["idBrano"]+');"></i>'+
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
	$("#labelBenvenuto").show();
	$("#logoutButton").show();
	$("#loginButton").hide();
	$("#signinButton").hide();
	
	
	
	console.log("sono in afterlogin");
	//$(".albums").html("");
	
}

function PlayBrano(idbrano){
	
	console.log("sono in playbrano");
	//$(".albums").html("");
	
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'addascolto',
					"brano" : idbrano
			
					
			},
    success: function (data) {
    	console.log("sono in playbrano");
    	if(data==1)
    	{
    	alert("ascolto da loggato")
    	}
    else if(data==0)
    	{
    	alert("ascolto da non loggato")
    	}
  
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });//ajax
	
}


function caricaArtisti(){
	
	console.log("sono nel carica nuovi artisti");
	//$(".albums").html("");
	
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'artisti'
					
			},
    success: function (data) {
    	//console.log("sono in success");
    	//console.log(data);
    	for(var i=0; i<data.length && i<8;i++){ /*
    		$(".tab-content").append('<div class="col-md-3 content-grid">'+
										'<a class="play-icon popup-with-zoom-anim" ><img src="'+data[i]["linkImg"]+'" title="allbum-name"></a>'+
										'<a class="button play-icon popup-with-zoom-anim" href="#" onclick="PlayBrano('+data[i]["idBrano"]+');">'+data[i]["titolo"]+'</a><div class="inner-info"><h5>'+data[i]["genere"]+'</h5></div>'+
										'<i class="glyphicon glyphicon-play-circle" onclick="PlayBrano('+data[i]["idBrano"]+');"></i>'+
										'</div>'
    			);*/
    		$(".browse-inner").append('		<div class="col-md-3 artist-grid"> '+
    									'	<a  href="single.html"><img src="images/a3.jpg" title="allbum-name"></a> '+
    									'	<a href="single.html"><i class="glyphicon glyphicon-play-circle"></i></a> '+
    									'	<a class="art" href="single.html">Sukhwinder singh</a> '+
    									'	</div> '+
    									'	</div> ');
    		console.log(data[i]["linkImg"]);
    	}
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });//ajax
	
}

