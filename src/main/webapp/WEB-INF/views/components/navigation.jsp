<div class="navContainer">
        <div class="ui secondary  menu">
            <a href="/" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/' ? 'active' : ''}">
                Home
            </a>
            <a href="/patients" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/patients' ? 'active' : ''}">
                Patients
            </a>
            <a href="/consultations" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/consultations' ? 'active' : ''}">
                Consultations
            </a>
            <div class="right menu">
                <div class="item">
                    <div class="ui simple dropdown item">
                        Add
                        <i class="plus icon"></i>
                        <div class="menu">
                            <div class="item"><a href="/add/patient">Patient</a></div>
                            <div class="item"><a href="/add/consultant">Consultant</a></div>
                            <div class="item"><a href="/add/consultation">Consultation</a></div>
                            <div class="item"><a href="/add/illness">Illness</a></div>
                            <div class="item"><a href="/add/diagnosis">Diagnosis</a></div>
                            <div class="item"><a href="/add/drug">Drug</a></div>
                            <div class="item"><a href="/add/treatment">Treatment</a></div>
                        </div>
                    </div>
                </div>

                <a class="ui item">
                    Logout
                </a>
            </div>
        </div>
</div>