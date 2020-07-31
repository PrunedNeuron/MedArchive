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
        <div class="right menu centered">
            <a href="#" style="text-decoration: none; color: inherit; margin: 1rem;">Add&nbsp;+</a>
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
        </div>
    </div>
</nav>