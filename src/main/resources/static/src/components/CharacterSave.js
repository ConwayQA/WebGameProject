import axios from "axios";
import API from './API';

function CharacterSave() {
    API.post('/getInventoryByCharacterID/2')
        .then((response) => {
            console.log(response);
        })
        .catch((error) => {
            console.log(error)
        });
}

export default CharacterInventory;