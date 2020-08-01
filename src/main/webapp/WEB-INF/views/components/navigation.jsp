<nav>
    <div class="ui secondary  menu" style="height: 1rem;">
        <a href="/" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/' ? 'active' : ''}">
            Home
        </a>
        <a href="/patients" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/patients' ? 'active' : ''}">
            Patients
        </a>
        <a href="/consultations" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/consultations' ? 'active' : ''}">
            Consultations
        </a>
        <a class="item">
            More
        </a>
        <div class="uk-navbar-dropdown uk-margin-remove" uk-dropdown="pos: bottom-right">
            <ul class="uk-nav uk-navbar-dropdown-nav">
                <li><a href="/consultant">Consultants</a></li>
                <li><a href="/illnesses">Illnesses</a></li>
                <li><a href="/diagnoses">Diagnoses</a></li>
                <li><a href="/drugs">Drugs</a></li>
                <li><a href="/treatments">Treatments</a></li>
            </ul>
        </div>
        <div class="right menu centered">
            <a href="#" class="item">Add&nbsp;+</a>
            <div class="uk-navbar-dropdown uk-margin-remove" uk-dropdown="pos: bottom-right">
                <ul class="uk-nav uk-navbar-dropdown-nav">
                    <li><a href="/add/patient">Patient</a></li>
                    <li><a href="/add/consultant">Consultant</a></li>
                    <li><a href="/add/consultation">Consultation</a></li>
                    <li><a href="/add/illness">Illness</a></li>
                    <li><a href="/add/diagnosis">Diagnosis</a></li>
                    <li><a href="/add/drug">Drug</a></li>
                    <li><a href="/add/treatment">Treatment</a></li>
                </ul>
            </div>
            <a href="#" class="item">Logout</a>
        </div>
    </div>
</nav>