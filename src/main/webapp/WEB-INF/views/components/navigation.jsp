<nav>
    <div class="ui secondary  menu" style="height: 1rem;">
        <a href="/" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/' ? 'active' : ''}">
            <i style="width: 1rem; margin-bottom: 0.2rem; margin-right: 0.5rem" class="fas fa-home"></i>Home
        </a>
        <a href="/patients" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/patients' ? 'active' : ''}">
            <i style="width: 1rem; margin-bottom: 0.2rem; margin-right: 0.5rem" class="fas fa-hospital-user"></i>Patients
        </a>
        <a href="/consultations" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/consultations' ? 'active' : ''}">
            <i style="width: 1rem; margin-bottom: 0.2rem; margin-right: 0.5rem" class="fas fa-user-md"></i>Consultations
        </a>
        <a class="item">
            More <i style="width: 1rem; margin-bottom: 0.4rem; margin-left: 0.3rem" class="fas fa-sort-down"></i>
        </a>
        <div class="uk-navbar-dropdown uk-margin-remove" uk-dropdown="pos: bottom-right">
            <ul class="uk-nav uk-navbar-dropdown-nav">
                <li><a href="/consultants">Consultants</a></li>
                <li><a href="/illnesses">Illnesses</a></li>
                <li><a href="/diagnoses">Diagnoses</a></li>
                <li><a href="/drugs">Drugs</a></li>
                <li><a href="/treatments">Treatments</a></li>
            </ul>
        </div>
        <div class="right menu centered">
            <a href="#" class="item">Add&nbsp;<i style="width: 1rem; margin-bottom: 0.1rem; margin-left: 0.3rem" class="fas fa-plus"></i></a>
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