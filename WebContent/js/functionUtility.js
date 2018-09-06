
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
										'<a><i id='+ data[i]["linkVideo"]+' class="glyphicon glyphicon-play-circle" onclick="PlayBrano('+data[i]["idBrano"]+',this.id,player); "></i></a>'+
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

function PlayBrano(idbrano, linkVideo, player){
	
	
	alert("sono in play brano"+linkVideo);
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
    	//console.log("sono in playbrano");
    	if(data==1)
    	{
    	alert("ascolto il brano con id: "+idbrano);
    	//Youtubeplayer.player.loadVideoById(linkVideo, 5, "large");
   	 	//$('.modalVideo').modal('show');
    	
    	$('.modalVideo').modal('show');
    	}
    else if(data==0)
    	{
    	alert("ascolto da non loggato il brano con id: "+idbrano);
    	//Youtubeplayer.player.loadVideoById(linkVideo, 5, "large");
    	//$('.modalVideo').modal('show');
    	
    	$('.modalVideo').modal('show');
    	}
  
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });
	  player.loadVideoById(linkVideo, 5, "large");
	  //ajax
	  /*console.log("---------------"+linkVideo);
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'riproduciVideo',
					"linkVideo" : linkVideo
			
					
			},
    success: function (data) {
    	//console.log("sono in playbrano");
    	if(data==1)
    	{
    		
    	alert("riproduce video");
    	 $('.modalVideo').modal('show');
    	}
    else if(data==0)
    	{
    	alert("non riproduce video");
    	}
  
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });//ajax*/
	
}


function caricaArtisti(){
	
	console.log("sono nel carica nuovi artisti");
	//$(".albums").html("");
	
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'allartisti'
					
			},
    success: function (data) {
    	//console.log("sono in success");
    	//console.log(data);
    	for(var i=0; i<data.length && i<8;i++){ 
    		console.log(data);
    		$(".browse-inner").append('		<div class="col-md-3 artist-grid"> '+
    									'	<a  "><img src="'+data[i]["linkImg"]+'" title="allbum-name"></a> '+
    									'	<a class="art" ">'+data[i]["alias"]+'</a> '+
    									'	</div> '+
    									'	</div> ');
    		//	<a href="single.html"><i class="glyphicon glyphicon-play-circle"></i></a> '+
    	}
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });//ajax
	
}

function caricaBrani(){
	
	console.log("sono in carica brani");
	//$(".albums").html("");
	
	  $.ajax({
	    	
		  contentType: "application/json; charset=utf-8",
          type : "GET",
			url : "FunctionServlet",
			data: { "action" : 'allbrani'
					
			},
    success: function (data) {
    	//console.log("sono in success");
    	
    	for(var i=0; i<data.length;i++){ 
    		console.log(data[i]["linkVideo"]);
    		
    		$(".browse").append(
    		
    							'		<div class="col-md-3 browse-grid">	'+
    							'		<a  ><img src="'+data[i]["linkImg"]+'" title="allbum-name"></a>	'+
    							'		<a><i id='+ data[i]["linkVideo"]+' class="glyphicon glyphicon-play-circle" onclick="PlayBrano('+data[i]["idBrano"]+',this.id,player); "></i></a>	'+
    							'		<a class="sing" >'+data[i]["titolo"]+'</a>	');
    		//	<a href="single.html"><i class="glyphicon glyphicon-play-circle"></i></a> '+
    	}
    },//success
    	error: function(xhr, status, error) {

   	  alert(xhr.responseText);
   	}

    });//ajax
	
}

