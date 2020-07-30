<div class="navContainer">
    <nav class="uk-navbar-container uk-navbar-transparent" uk-navbar>

        <div class="uk-navbar-left">

            <ul class="uk-navbar-nav">
                <li class="${requestScope['javax.servlet.forward.request_uri'] eq '/' ? 'uk-active' : ''}" ><a href="/">Home</a></li>
                <li class="${requestScope['javax.servlet.forward.request_uri'] eq '/patients' ? 'uk-active' : ''}"><a href="/patients">Patients</a></li>
                <li class="${requestScope['javax.servlet.forward.request_uri'] eq '/consultations' ? 'uk-active' : ''}"><a href="/consultations">Consultations</a></li>
            </ul>

        </div>

        <div class="uk-navbar-center">
            MedArchive
        </div>
        <div class="uk-navbar-right">

            <ul class="uk-navbar-nav">
                <li>
                    <a href="#" uk-icon="plus">Add&nbsp;</a>
                    <div class="uk-navbar-dropdown" uk-dropdown="pos: bottom-right">
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
                </li>
            </ul>

        </div>
    </nav>
    <hr class="uk-divider-icon">
</div>