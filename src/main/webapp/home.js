/**
 * 
 */
function cfun()
	{
	  document.getElementById("mydropdown").classList.toggle("show");
	}
function ufun()
{
  document.getElementById("mydropdown1").classList.toggle("show");
}
window.onclick = function(event) {
  if (!event.target.matches('.dropbtn')) {
    var dropdown = document.getElementsById("dropdown");
    var i;
    for (i = 0; i < dropdown.length; i++) {
      var openDropdown = dropdowns[i];
      if (openDropdown.classList.contains('show')) {
        openDropdown.classList.remove('show');
      }
    }
  }
}
//tab files
function sc(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","csearch.html",true);
	xhttp.send();
}
function ac(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","criminal_reg.html",true);
	xhttp.send();
}
function dc(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Criminaldisplay",true);
	xhttp.send();
}
function su(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","usearch.html",true);
	xhttp.send();
}
function au(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","user_reg.html",true);
	xhttp.send();
}
function du(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Userdisplay",true);
	xhttp.send();
}
function h(){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","Login.html",true);
	xhttp.send();
}
function changepwd(n){
	var xhttp=new XMLHttpRequest();
	xhttp.onreadystatechange=function(){
		if(xhttp.readyState==4 && xhttp.status==200){
			document.getElementById("sc").innerHTML=xhttp.responseText;
		}
	}
	xhttp.open("GET","changepassword.jsp?name="+n,true);
	xhttp.send();
}
function logout(){
	    if(confirm("Are you sure you want to Logout?")){		
			location.href="Login.html";
		}
}