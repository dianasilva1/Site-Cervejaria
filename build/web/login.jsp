<!DOCTYPE html>
<html lang="en"> 
<head>
     <title>Cervejaria Casa da Cerveja</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="img/chope.png" />
    
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <meta name="description" content="Portal - Bootstrap 5 Admin Dashboard Template For Developers">
    <meta name="author" content="Xiaoying Riley at 3rd Wave Media">    
    <link rel="shortcut icon" href="favicon.ico"> 
    
    <!-- FontAwesome JS-->
    <script defer src="assets/plugins/fontawesome/js/all.min.js"></script>
    
    <!-- App CSS -->  
    <link id="theme-style" rel="stylesheet" href="assets/css/portal.css">

</head> 

<body class="app app-login p-0">    	
    <div class="row g-0 app-auth-wrapper">
	    <div class="col-12 col-md-7 col-lg-6 auth-main-col text-center p-5">
		    <div class="d-flex flex-column align-content-end">
			    <div class="app-auth-body mx-auto">	
				    <div class="app-auth-branding mb-4"></div>
					<h2 class="auth-heading text-center mb-5">Entre na sua conta</h2>
			        <div class="auth-form-container text-start">
						 <form method="POST" action="Login">       
							<div class="email mb-3">
								<label class="form-label">E-mail</label>
                                                <input class="form-control form-control-lg" type="email" name="emailcliente" placeholder="Entre com seu e-mail" required="required" />
							</div><!--//form-group-->
							<div class="password mb-3">
								<label class="form-label">Senha</label>
                                                <input class="form-control form-control-lg" type="password" name="senhacliente" placeholder="Entre com sua senha" required="required"/>
								<div class="extra mt-3 row justify-content-between">
									<div class="col-6">
										
									</div><!--//col-6-->
									
								</div><!--//extra-->
							</div><!--//form-group-->
							<div class="text-center">
								<button type="submit" class="btn app-btn-primary w-100 theme-btn mx-auto">Entrar</button>
							</div>
                                                        <h4></br>
                                                ${msg}
                                            </h4>
						</form>
						
						
					</div><!--//auth-form-container-->	

			    </div><!--//auth-body-->
		    
			    <footer class="app-auth-footer">
				    <div class="container text-center py-3">
				         <!--/* This template is free as long as you keep the footer attribution link. If you'd like to use the template without the attribution link, you can buy the commercial license via our website: themes.3rdwavemedia.com Thank you for your support. :) */-->
			        <small class="copyright">Desenvolvido <i class="fas fa-heart" style="color: #fb866a;"></i> por Diana Silva </small>
				       
				    </div>
			    </footer><!--//app-auth-footer-->	
		    </div><!--//flex-column-->   
	    </div><!--//auth-main-col-->
	    <div class="col-12 col-md-5 col-lg-6 h-100 auth-background-col">
		    <div class="auth-background-holder">
		    </div>
		    <div class="auth-background-mask"></div>
		    <div class="auth-background-overlay p-3 p-lg-5">
			    <div class="d-flex flex-column align-content-end h-100">
				    <div class="h-100"></div>
				    <div class="overlay-content p-3 p-lg-4 rounded">
					    <h5 class="mb-3 overlay-title">Cervejaria Casa da Cerveja</h5>
                                    </div>
				</div>
		    </div><!--//auth-background-overlay-->
	    </div><!--//auth-background-col-->
    
    </div><!--//row-->


</body>
</html> 

