<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<!DOCTYPE html>
<html>
<head>

<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css" integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">

<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.2/jquery.min.js"></script>

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js" integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS" crossorigin="anonymous"></script>



	<title>Home</title>



</head>
<body>

<nav class="navbar navbar-default navbar-fixed-top" role="navigation">
        <div class="container">
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand page-scroll" href="#page-top">Start Bootstrap</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav">
                    <!-- Hidden li included to remove active class from about link when scrolled up past about section -->
                    <li class="hidden">
                        <a class="page-scroll" href="#page-top"></a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#about">About</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#services">Services</a>
                    </li>
                    <li>
                        <a class="page-scroll" href="#contact">Contact</a>
                    </li>
                </ul>
                <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
    </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>
    
    
<div>


<style>
@import url(http://fonts.googleapis.com/earlyaccess/hanna.css);

#title{
  background-color:#969696; 
/* 	margin: 50px;  */
	  padding:80px; 
	  color: black;
}

.bootstrap-demo{
 padding:50px; 

}


</style>

<h1 id="title" align="center" style="font-family: fantasy; color: black">MANI MANY<br>
<p class="lead" style="font-family:'Nanum Gothic'; color: #dcdcdc">Libraries using Web services created for students to use the library more often is " Manny Manny library .<br>

The program will support students anywhere, anytime to use the library to use the library frequently . 

</p>

</h1>




<div class="container">



<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- Indicators -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
		</ol>
		<!-- style='position: relative; top:-200' -->
		<!-- Wrapper for slides -->
		<div class="carousel-inner" role="listbox" style="width: 1158; height: 444">


			<div class="item active">
				<img src="https://scontent.xx.fbcdn.net/hphotos-xpl1/t31.0-8/12898210_121434794921280_5728082899501911314_o.jpg">

				<div class="carousel-caption">
					<h1 style="color: #FFFFFF">Don't stop the fashion</h1>
					<p style="color: #FFFFFF">Beauty is nature's coin, must not be
						hoarded,but must be current,</p>
					<p style="color: #FFFFFF">and the good there of consists in
						mutual and partaken bliss.</p>
				</div>

			</div>


			<div class="item">
				<img src="https://scontent.xx.fbcdn.net/hphotos-xaf1/t31.0-8/12898409_121419598256133_5437606159514345821_o.jpg"  title="cold" alt="...">
				<div class="carousel-caption">
					<h1>Cold Play</h1>
					<p class="lead">Parachutes A Rush of Blood to the Head X&Y Viva
						la Vida or Death and All His Friends Mylo Xyloto Ghost Stories</p>
				</div>
			</div>


			<div class="item">
				<img align="middle" src="https://scontent.xx.fbcdn.net/hphotos-xaf1/t31.0-8/12909531_121423344922425_8489312002504703306_o.jpg" >

				<div class="carousel-caption">
					<h1 style="color: #FFFFFF">It's come from saying 'no' to 1,000
						things</h1>
					<p class="lead" style="color: #FFFFFF">I think if you do
						something and it turns out pretty good, then you should go do
						something else wonderful, not dwell on it for too long.</p>

				</div>

			</div>
		</div>





		<!-- Controls -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"> <span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span>
		</a> <a class="right carousel-control" href="#carousel-example-generic"
			role="button" data-slide="next"> <span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span>
		</a>
	</div>

	<script type="text/javascript">
		$('.carousel').carousel({
			interval : 2000
		})
	</script>




<div class="bootstrap-demo">
<div class="row">

      <div class="col-sm-6 col-md-4"> <!-- column 1 -->
        <div class="thumbnail"> <!--  thumbnail 1  -->
          <img src="http://www.tutorialspark.com/twitterBootstrap/china.jpg" alt="china thumbnail"> <!-- image 1 -->
          <div class="caption"> <!-- caption -->
            <h3>The Great Wall of China</h3>
            <p>The Great Wall of China is a series of fortifications
              made of stone, brick, tamped earth, wood, and other
              materials, generally built along an east-to-west line 
              across the historical northern borders of China</p>
            <p><a href="#" class="btn btn-primary" role="button">Buy Tickets</a> <!-- btn 1 -->
              <a href="#" class="btn btn-default" role="button">Add to Wishlist</a></p>  <!-- btn 2 -->
          </div>
        </div>
      </div>
	  
      <div class="col-sm-6 col-md-4"> <!-- column 2 -->
        <div class="thumbnail"> <!-- thumbnail 2 -->
          <img src="http://www.tutorialspark.com/twitterBootstrap/statue-liberty.jpg" alt="Statue of Liberty thumbnail">  <!-- image 2 -->
          <div class="caption">  <!-- caption -->
            <h3>Statue of Liberty</h3>
            <p>The Statue of Liberty is a colossal neoclassical sculpture on Liberty
              Island in the middle of New York Harbor, in Manhattan, New York City.</p>
            <p><a href="#" class="btn btn-primary" role="button">Buy Tickets</a>   <!-- btn 1 -->
              <a href="#" class="btn btn-default" role="button">Add to Wishlist</a></p>  <!-- btn 2 -->
          </div>
        </div>
      </div>
      
      <div class="col-sm-6 col-md-4"> <!-- column 2 -->
        <div class="thumbnail"> <!-- thumbnail 2 -->
          <img src="https://scontent.xx.fbcdn.net/hphotos-xtl1/t31.0-8/12671674_121428374921922_1736655941279239457_o.jpg" alt="Statue of Liberty thumbnail">  <!-- image 2 -->
          <div class="caption">  <!-- caption -->
            <h3>Statue of Liberty</h3>
            <p>The Statue of Liberty is a colossal neoclassical sculpture on Liberty
              Island in the middle of New York Harbor, in Manhattan, New York City.</p>
            <p><a href="#" class="btn btn-primary" role="button">Buy Tickets</a>   <!-- btn 1 -->
              <a href="#" class="btn btn-default" role="button">Add to Wishlist</a></p>  <!-- btn 2 -->
          </div>
        </div>
      </div>
      
</div>
  </div>

<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>




</div>


</body>
</html>
