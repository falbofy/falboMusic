/*$("#loginForm").submit(function(evt) {
		evt.preventDefault();*/
function loginuser(){
		console.log("username=",$("#uname").val());
		console.log("psw=",$("#psw").val());
		
		     $.ajax({
		    	 
		           type : "POST",
		 			url : "AccessServlet",
		 			data: { "action" : 'login',
		 					"uname" : $("#uname").val(),
		 			
		 					"psw" : $("#psw").val()
		 			},
		     success: function (data) {
		    	         
		        if(data==1)
		        	{
		        	
		        	console.log("sono inlogin effettuato");
		        	
		        	afterLogin();
		        	
		        	
			
		           /* $("#b1").remove();//prop("disabled",true);
		        	$("#goback").show();*/
		        	}
		        else if(data==0)
		        	{
		        	
		        	console.log("sono inlogin errato");
		        	}
		      
		     },//success
		     	error: function(xhr, status, error) {
		 
		    	  alert(xhr.responseText);
		    	}

		     });//ajax
}  
	//});

function logoutuser(){
		
		     $.ajax({
		    	 
		           type : "POST",
		 			url : "AccessServlet",
		 			data: { "action" : 'logout',

		 			},
		     success: function (data) {
		    	 location.reload();
		      
		     },//success
		     	error: function(xhr, status, error) {
		 
		    	  alert(xhr.responseText);
		    	}

		     });//ajax
}  
	
function controllauser(){
	console.log("il valore di username is"+$("#usrreg").val());
	/*if($.trim($("#usrreg").html())=='')
	{	 console.log("sono in cotrolla user- primoif e vale"+$("#usrreg").val());
		 $("#availability").text("").css({ 'color': 'blue', 'font-size': '100%' });
	}
	else{*/ console.log("sono in cotrolla user- parte ajax");
	$.ajax({
		
		type : "POST",
		url : "AccessServlet?action=checkusername",
		datatype : "json",
		data : { 
					datapkt : JSON.stringify({"useridea": $("#usrreg").val()} )
			
				},
		
		success: function(data){
			
			if(data==1){
			 $("#availability").text("username disponibile").css({ 'color': 'green', 'text-align': 'center', 'font-size': '100%' });
			 $("#submitregbutton").show();
			}
			else if(data==0)
			{
			 $("#availability").text("username gia' in uso").css({ 'color': 'red', 'font-size': '100%' });
			}
		
		}//success	
				
								
	}); //ajax

	//}//else empty
}




	/*$("#registerForm").submit(function(evt) {
		evt.preventDefault();*/
function registraUtente(){
		     $.ajax({
		    	 
		           type : "POST",
		 			url : "AccessServlet",
		 			data: { "action" : 'register',
		 					"usr" : $("#usrreg").val(),
		 					"psw" : $("#pswreg").val(),
		 					"nome" : $("#nome").val(),
		 					"cognome" : $("#cognome").val(),
		 					"pswrepeat": $("#pswrepeat").val(),
		 			},
		     success: function (data) {
		    	         
		        if(data==1)
		        	{
		        	$("#statusreg").text("Registrazione Effettuata").css({ 'color': 'green', 'text-align': 'center', 'font-size': '100%' });
		        	console.log("registrazione effettuata");
		        	afterLogin();
			
		        	}
		        else if(data==0)
	        	{
		        $("#statusreg").text("errore! controlla i dati inseriti").css({ 'color': 'red', 'font-size': '100%' });
	        	console.log("errore! controlla i dati inseriti");
	        	}
		        else if(data==2)
	        	{
		        $("#statusreg").text("utente gia registrato").css({ 'color': 'red', 'font-size': '100%' });
	        	console.log("errore! utente gia registrato");
	        	}
		     },//success
		     	error: function(xhr, status, error) {
		 
		    	  alert(xhr.responseText);
		    	}

		     });//ajax 
}
//	});

function controlloLogin(){
	
		
	     $.ajax({
	    	 
	           type : "GET",
	 			url : "AccessServlet",
	 			data: { "action" : 'islogged',

	 			},
	     success: function (data) {
	    	 if(data==1)
	        	{
	        	afterLogin();	
	        	}
	       
	      
	     },//success
	     	error: function(xhr, status, error) {
	 
	    	  alert(xhr.responseText);
	    	}

	     });//ajax 
	
}