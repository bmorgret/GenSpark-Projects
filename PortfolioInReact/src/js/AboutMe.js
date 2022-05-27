function AboutMe(){
    return(
        <section class="about-area">
            <div class="container">
                <div class="row text-center">
                    <div class="col-12">
                        <div class="about-title">
                            <h1 class="text-uppercase title-h1">What My Clients Say about me</h1>
                            
                        </div>
                    </div>
                </div>
            </div>

            <div class="container carousel py-lg-5">
                <div class="owl-carousel owl-theme">
                    <div class="client row">
                        <div class="col-lg-4 col-md-12 client-img">
                            <img src="./img/testimonials/stevejobs.jpg" alt="img1" class="img-fluid"/>
                        </div>
                        <div class="col-lg-8 col-md-12 about-client">
                            <h4 class="text-uppercase">Steve Jobs</h4>
                            <p class="para">Your time is limited, so don't waste it living someone else's life. Don't be 
                                trapped by dogma which is living with the results of other people's thinking.</p>
                        </div>
                    </div>
                    <div class="client row">
                        <div class="col-lg-4 col-md-12 client-img">
                            <img src="./img/testimonials/WaltDisney.jpeg" alt="img2" class="img-fluid"/>
                        </div>
                        <div class="col-lg-8 col-md-12 about-client">
                            <h4 class="text-uppercase">Walt Disney</h4>
                            <p class="para">The way to get started is to quit talking and begin doing.</p>
                        </div>
                    </div>
                    <div class="client row">
                        <div class="col-lg-4 col-md-12 client-img">
                            <img src="./img/testimonials/dukeellington.jpg" alt="img1" class="img-fluid"/>
                        </div>
                        <div class="col-lg-8 col-md-12 about-client">
                            <h4 class="text-uppercase">Duke Ellington</h4>
                            <p class="para">There are two kinds of music. Good music, and the other kind.</p>
                        </div>
                    </div>
                    <div class="client row">
                        <div class="col-lg-4 col-md-12 client-img">
                            <img src="./img/testimonials/nelsonmandela.jpg" alt="img2" class="img-fluid"/>
                        </div>
                        <div class="col-lg-8 col-md-12 about-client">
                            <h4 class="text-uppercase">Nelson Mandela</h4>
                            <p class="para">The greatest glory in living lies not in never falling, but in rising 
                                every time we fall.</p>
                        </div>
                    </div>
                    <div class="client row">
                        <div class="col-lg-4 col-md-12 client-img">
                            <img src="./img/testimonials/henryford.jpg" alt="img1" class="img-fluid"/>
                        </div>
                        <div class="col-lg-8 col-md-12 about-client">
                            <h4 class="text-uppercase">Henry Ford</h4>
                            <p class="para">Whether you think you can or you think you can't, you're right.</p>
                        </div>
                    </div>
                    <div class="client row">
                        <div class="col-lg-4 col-md-12 client-img">
                            <img src="./img/testimonials/johnlennon.jpeg" alt="img2" class="img-fluid"/>
                        </div>
                        <div class="col-lg-8 col-md-12 about-client">
                            <h4 class="text-uppercase">John Lennon</h4>
                            <p class="para">Life is what happens when you're busy making other plans.</p>
                        </div>
                    </div>
                </div>
            </div>

        </section>

    )
}
export default AboutMe