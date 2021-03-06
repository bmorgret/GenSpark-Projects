
function Banner() {
    return (
        <section class="site-banner">
            <div class="container">
                <div class="row">
                    <div class="col-lg-6 col-md-12 site-title">
                        <h3 class="title-text">Welcome</h3>
                        <h1 class="title-text text-uppercase">Brian Morgret</h1>
                        <h4 class="title-text text-uppercase">Java Full Stack Developer</h4>
                        <div class="site-buttons">
                            <div class="d-flex flex-row flex-wrap">
                                <button type="button" class="btn button primary-button mr-4 text-uppercase">hire
                                    me</button>
                                <button type="button" class="btn button secondary-button text-uppercase">Get cv</button>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6 col-md-12 banner-image">
                        <img src="img/BrianPicCropped.jpg" alt="banner-img" class="img-fluid"/>
                    </div>
                </div>
            </div>
        </section>
    );
}
export default Banner;