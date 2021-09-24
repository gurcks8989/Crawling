<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
	.mdl-button--icon {
	    height: <c:out value="${width/5}" />px;
	    min-width:  <c:out value="${width/5}" />px;
	    width: <c:out value="${width/5}" />px;
	    }
	    
	
	@media only screen and (min-width: <c:out value="${width + 50}" />px) {
		.mdl-layout__container{
			position:unset;
		}
		/* top-left | top-right | bottom-right | bottom-left */
		.mdl-layout__header {
		    border-radius: 30px 30px 0px 0px;
		}
		.mdl-layout__obfuscator {
		    border-radius: 30px ;
		}
		
		.mdl-layout__drawer {
		    border-radius: 30px 0px 0px 30px ;
		}
		.mdl-layout__drawer-button {
		    border-top-left-radius: 30px ;
		}
	}
	
    .mdl-badge.mdl-badge--overlap:after {
    	top: -20px ;
    	right: 0px;
	}
	
	@media screen and (min-width: 760px){
		.mdl-logo {
		    float: unset;
		    margin-bottom: unset;
		    margin-right: unset;
		}
	}
	.mdl-mega-footer__bottom-section, .mdl-mega-footer--bottom-section{
    	flex: auto;
   	}
   	
	.row{
		padding: 8px;
		display:flex;
		justify-content: center;
	}
	
	footer a:link { color: #95b8d1; text-decoration: none;}
	footer a:visited { color: #95b8d1; text-decoration: none;}
	footer a:hover { color: #809bce; text-decoration: underline;}

</style>