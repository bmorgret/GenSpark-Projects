function About() {
    return(
        <section class="about-area">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-6 col-md-12">
                        <div class="about-image">
                            <img src="./img/Java.png" alt="About us" class="img-fluid"/>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12 about-title">
                        <h2 class="text-uppercase pt-5">
                            <span>Let me</span>
                            <span>introduce</span>
                            <span>myself</span>
                        </h2>
                        <div class="paragraph py-4 w-75">
                            <p class="para">
                                I have been a professional computer programmer for over 30 years.  In that time I have
                                written software in many languages and industries.  I have recently completed a
                                Java Full Stack boot camp with GenSpark in order to modernize my skill set.
                            </p>
                            <p class="para">
                                I most enjoy the problem solving nature of computer programing.  Every project is a new
                                chance to solve a big puzzel and create something new that brings value to my clients 
                                business.
                            </p>
                        </div>
                        <button type="button" class="btn button primary-button text-uppercase">Download cv</button>
                    </div>
                </div>
            </div>
        </section>
    )
}
export default About;