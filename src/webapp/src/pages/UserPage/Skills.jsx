import javascriptimg from './Photo/javascript.png';
import htmlimg from './Photo/html.png';
import cssimg from './Photo/css.png';
import javaimg from './Photo/java.png';
import mongoimg from './Photo/mongodb.png';
import databaseimg from './Photo/psql.png'

const Skills = () => {
    return(
    <section id="skillheader" className="flex-project-container">

        <div><img src={javascriptimg} width="100" height="100" alt="js"/></div>
        <div><img src={htmlimg} width="100" height="100" alt="html"/></div>
        <div><img src={cssimg} width="100" height="100" alt="css"/></div>
        <div><img src={javaimg} width="100" height="100" alt="java"/></div>
        <div><img src={mongoimg} width="100" height="100" alt="mongodb"/></div>
        <div><img src={databaseimg} width="100" height="100" alt="db"/></div>

    </section>
    )
}

export default Skills;
