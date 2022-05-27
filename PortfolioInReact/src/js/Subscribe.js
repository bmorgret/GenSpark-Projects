function Subscribe(){
    return(
        <section class="subscribe-us-area">
            <div class="container subscribe">
                <div class="row">
                    <div class="col-lg-12 text-center subscribe-title">
                        <h4 class="text-uppercase">Get Update From anywhere</h4>
                        <p class="para">Sign up for my newsletter and keep up with all the latest.</p>
                    </div>
                </div>
                <div class="d-sm-flex justify-content-center">
                    <form class="w-50">
                        <div class="row d-flex flex-row flex-wrap">
                            <div class="col input-textbox">
                                <input type="text" id="txtemail" class="form-control" placeholder="Email"/>
                            </div>
                            <div class="col">
                                <div class="btn-submit">
                                    <button type="submit" class="btn btn-success float-right">Subscribe</button>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </section>
    )
}
export default Subscribe