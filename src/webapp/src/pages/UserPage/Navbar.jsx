import './Main.css'

const Navbar = () => {
    return (
        <nav className="navbar">
            <a href="http://localhost:3000"><i className="fa fa-fw fa-home"></i>Home</a>
            <a href="#contactnav"><i className="fa fa-fw fa-envelope"></i>Contact</a>
            {/*<a href="#container-about"><i className="fa fa-fw fa-user"></i>About</a>*/}
            {/*<a href="#skillheader"><i className="fa fa-fw fa-xing"></i>Skills</a>*/}
            <a href="#questionheader"><i className="fa fa-fw fa-question"></i>Questions</a>
            <a href="#answerheader"><i className="fa fa-fw fa-handshake-o"></i>Answers</a>
        </nav>
    )
}

export default Navbar
