import axios from "axios";
import API from './API';

function CharacterInventory() {
    API.get('/getInventoryByCharacterID/2')
        .then((response) => {
            console.log(response);
        })
        .catch((error) => {
            console.log(error)
        });
}

export default CharacterInventory;