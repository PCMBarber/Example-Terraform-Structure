
const BusinessAddress = ({name, type, house, street, town, postcode}) => {
    return (

                <tr>
                    <td>{name}</td>
                    <td>{type}</td>
                    <td>{(house == false ? "-" : house)}</td>
                    <td>{street}</td>
                    <td>{(town == false ? "-" : town)}</td>
                    <td>{postcode}</td>
                </tr>

    )
}

export default BusinessAddress;