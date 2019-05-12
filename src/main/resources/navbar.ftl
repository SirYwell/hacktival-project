<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <a class="navbar-brand" href="#">Healthy Earth</a>
    <ul class="navbar-nav">
        <li class="nav-item" id="nav-home"><a class="nav-link" href="/"">Home</a></li>
        <li class="nav-item" id="nav-leaderboard"><a class="nav-link" href="leaderboard">Leaderboard</a></li>
        <li class="nav-item" id="nav-weekly-check-in"><a class="nav-link" href="weekly-check-in">Weekly Check In</a></li>
        <li class="nav-item" id="nav-settings"><a class="nav-link" href="settings">Settings</a></li>
    </ul>

    <ul class="nav navbar-nav ml-auto">
        <#if currentUser??>
                <li class="nav-item"><a class="nav-link" href="#"><span>${currentUser} <i class="fas fa-user"></i></span></a></li>
            <#else>
                <li class="nav-item"><a class="nav-link" href="#"><span>Sign Up <i class="fas fa-user"></i></span></a></li>
                <li class="nav-item"><a class="nav-link" href="#myModal" data-toggle="modal"><span>Login <i class="fas fa-sign-in-alt"></i></span></a></li>
        </#if>
    </ul>
</nav>