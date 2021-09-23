<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Main Navigation-->
<!-- Loading -->

<style>
	#menu_user_icon {
		margin-top: 50px;
		font-size: 100px;
	}
	
	#menu_user_div {
		text-align: center;
	}
	
	@media screen and (min-width: 1025px) {
		#menu_user_div {
			text-align: center;
		}
	}
	
	
	.main_logo>a {
		font: italic bold 1.5em/1em Georgia, serif;
	}
	
	#lower {
		color: white;
	}
	
	@media only screen and (min-width: <c:out value="${width + 50}" />px) {
	
		.body{
		  min-height: 100vh ;
		  display: flex ;
		  justify-content: center ;
		  align-items: center ;
		  font-family: 'Roboto', sans-serif ;
		}
		.divice{    
			position: absolute;
			width: <c:out value="${width}" />px ;
			height: <c:out value="${height}" />px ;
			background : white ;
			border-radius : 30px ;
		}
		.outline{
			width: <c:out value="${width + 50}" />px ;
			height: <c:out value="${height + 50}" />px ;
			background : #383838 ;
			border-radius: 50px ;	
		}
	}
	#photo{
	    border-radius: 10px 20px / 20px 10px;
    }
</style>