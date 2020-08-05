
<style>

    .navItem a {
        display: flex;
    }

</style>

<nav>
    <div class="navContainer noselect">
        <div class="navLeft">
            <div class="navItem ${requestScope['javax.servlet.forward.request_uri'] eq '/' ? 'active' : ''}">
                <a href="/" class="item">
                    <i class="fas fa-home"></i>Home
                </a>
            </div>
            <div class="navItem ${requestScope['javax.servlet.forward.request_uri'] eq '/patients' ? 'active' : ''}">
                <a href="/patients"
                   class="item">
                    <i class="fas fa-hospital-user"></i>Patients
                </a>
            </div>
            <div class="navItem ${requestScope['javax.servlet.forward.request_uri'] eq '/consultations' ? 'active' : ''}">
                <a href="/consultations"
                   class="item">
                    <i class="fas fa-user-md"></i>Consultations
                </a>
            </div>
            <div class="dropdown">
                <div class="navItem">
                    <a>
                        More <i class="fas fa-sort-down"></i>
                    </a>
                </div>
                <ul class="dropdown-content">
                    <li><a href="/consultants">Consultants</a></li>
                    <li><a href="/illnesses">Illnesses</a></li>
                    <li><a href="/treatments">Diagnoses</a></li>
                    <li><a href="/drugs">Drugs</a></li>
                    <li><a href="/treatments">Treatments</a></li>
                    <li><a href="/tests">Tests</a></li>
                </ul>
            </div>
        </div>
        <div class="navRight">
            <div class="dropdown">
                <div class="navItem">
                    <a href="#" class="item">Add&nbsp;<i class="fas fa-plus"></i></a>
                </div>
                <ul class="dropdown-content">
                    <li><a href="/add/patient">Patient</a></li>
                    <li><a href="/add/consultant">Consultant</a></li>
                    <li><a href="/add/consultation">Consultation</a></li>
                    <li><a href="/add/illness">Illness</a></li>
<%--                    <li><a href="/add/diagnosis">Diagnosis</a></li>--%>
                    <li><a href="/add/drug">Drug</a></li>
<%--                    <li><a href="/add/treatment">Treatment</a></li>--%>
<%--                    <li><a href="/add/test">Test</a></li>--%>
                </ul>
            </div>
        </div>
    </div>
</nav>