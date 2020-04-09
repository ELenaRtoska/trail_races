import React from 'react';
import {Link} from "react-router-dom";
import Table from "../../Table/table";
import '../../App/App.css';

const ShowRaces = (props) => {
    let tableItems = props.races.length === 0 ?


            <ul>
                <li>
                    <b>
                    <i>
                        <br />
                    There are the most famous races in the Republic of Macedonia. You don't need to wander around to look at them all separately.

                    <br />
                    It is enough to know how much kilometers there are, denivelation and the fastest time of the race.

                    <br />

                    Additionally, you have a picture of each race to see what the previous event looked like.

                    </i>
                    </b>
                </li>
                <br />
                <br />



                <li>
                <img src="/images/kozjak.jpg" alt=""/>
                    <i><b>Kozjak Vertical Kilometre</b>(3.7km, 1050D+, 1:18:05)</i>
                </li>
                <br />


                <li>
                <img src="/images/matka.jpg" alt=""/>
                    <i><b>Vodno-Matka half marathon</b>(26km, 1650D+, 4:18:52)</i>
                </li>
                <br />

                <li>
                <img src="/images/titov.jpg" alt=""/>
                    <i><b>Titov Vrv SkyRace</b>(20km, 1900D+, 4:53:50)</i>
                </li>

                <br />


                <li>
                <img src="/images/evropsko.jpg" alt=""/>
                    <i><b>La Veia SkyRace - Italy</b>(31km, 2600D+, 5:33:08)</i>
                </li>

                <br />


                <li>
                <img src="/images/kmt.jpg" alt=""/>
                    <i><b>Krali Marko Trails</b>(34km, 1750D+, 5:14:56)</i>
                </li>

                <br />


                <li>
                <img src="/images/momata.jpg" alt=""/>
                    <i><b>Momata Rock Trail</b>(20km, 1050D+, 2:58:15)</i>
                </li>

                <br />


                <li>
                <img src="/images/skopski.jpg" alt=""/>
                    <i><b>Skopski polumaraton</b>(21km, 0D+, 1:28:15)</i>
                </li>

                <br />


                <li>
                <img src="/images/maraton.jpg" alt=""/>
                    <i><b>Skopski maraton</b>(42km, 0D+, 1:28:15)</i>
                </li>

                <br />


                <li>
                <img src="/images/prv.jpg" alt=""/>
                    <i><b>Prv do vrv</b>(7km, 700D+, 38:15)</i>
                </li>

                <br />


                <li>
                <img src="/images/kitka.jpg" alt=""/>
                    <i><b>Kitka Trail Run</b>(24km, 1200D+, 02:10:00)</i>
                </li>

            </ul>


:
        <Table items={props.races} {...props}/>;
    return (
        <div className={"container"}>
            <div className="row">

                <h4 className="text-upper text-left">Races</h4>
                <div className="table-responsive">
                    {tableItems}
                </div>
                {/*<Link className="btn btn-outline-secondary" to={`${props.match.url}/new`}>*/}
                {/*    <span><strong>Add new race</strong></span>*/}
                {/*</Link>*/}
            </div>
        </div>
    );
};

export default ShowRaces;