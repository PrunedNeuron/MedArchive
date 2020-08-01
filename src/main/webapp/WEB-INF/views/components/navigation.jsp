<nav>
    <div class="navContainer">
        <div class="navLeft">
            <div class="navItem">
                <a href="/" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/' ? 'active' : ''}">
                    <i class="fas fa-home"></i>Home
                </a>
            </div>
            <div class="navItem">
                <a href="/patients" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/patients' ? 'active' : ''}">
                    <i class="fas fa-hospital-user"></i>Patients
                </a>
            </div>
            <div class="navItem">
                <a href="/consultations" class="item ${requestScope['javax.servlet.forward.request_uri'] eq '/consultations' ? 'active' : ''}">
                    <i  class="fas fa-user-md"></i>Consultations
                </a>
            </div>
            <div class="navItem">
                <a class="item">
                    More <i class="fas fa-sort-down"></i>
                </a>
            </div>
            <div uk-dropdown="pos: bottom-justify">
                <ul class="uk-nav uk-dropdown-nav">
                    <li><a href="/consultants">Consultants</a></li>
                    <li><a href="/illnesses">Illnesses</a></li>
                    <li><a href="/treatments">Diagnoses</a></li>
                    <li><a href="/drugs">Drugs</a></li>
                    <li><a href="/treatments">Treatments</a></li>
                </ul>
            </div>

        </div>
        <div class="navRight">
            <div class="navItem">
                <a href="#" class="item">Add&nbsp;<i class="fas fa-plus"></i></a>
            </div>
            <div uk-dropdown="pos: bottom-right">
                <ul class="uk-nav uk-dropdown-nav">
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