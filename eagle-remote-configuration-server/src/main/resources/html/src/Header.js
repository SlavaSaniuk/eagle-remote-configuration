
class Header extends React.Component {
	constructor(props) {
		super(props);
	}

 render() {

 	const header_block_ui = (
	<div className="header_block">
		<PreferencesButton btn_id={1} btn_text={translate_Preferences_btn_text} pref_location={link_Preferences_controller}/>
	</div>
	);

 	return header_block_ui;
 }


}

ReactDOM.render(<Header />, document.getElementById('header'));