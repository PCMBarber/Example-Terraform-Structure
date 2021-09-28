const Associate = ({type, forenames, surname, dob}) => {
    return (
        <tr>
            <td>{forenames}</td>
            <td>{surname}</td>
            <td>{dob.substring(0,10)}</td>
        </tr>

    )
}

export default Associate;