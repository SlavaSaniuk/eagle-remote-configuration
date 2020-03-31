class PreferencesButton extends React.Component {
	constructor(props) {
		super(props);

		this.state = {mouse_entered: false};
	}

	//Enevnts handlers
	onClick(e, url) {
		e.preventDefault();
		console.log("redirect to Settngs page; " +url.toString());
		window.location.href = url.toString();
	}

	onMouseEnter() {
		this.setState(
			{mouse_entered: true}
		);
	}

	onMouseLeave() {
		this.setState(
			{mouse_entered: false}
		);
	}

	//Component methods
	getId(number_id) {
		return "preferences_btn_" +number_id;
	}



	render() {

		const hovered = this.state.mouse_entered;

		return (

			<div className="preferences_btn" id={this.getId(this.props.btn_id)} 
				onClick={(e, url) => this.onClick(e, this.props.pref_location)}
				onMouseEnter={() => this.onMouseEnter()} onMouseLeave={() => this.onMouseLeave()}>
				<img src={hovered ? 'img/preferences_button_hover.png' : 'img/preferences_button-min.png'}
					style={preferences_btn_img}
				/>
				<p style={hovered ? preferences_btn_text_hover : preferences_btn_text}> {this.props.btn_text} </p>
			</div>
			);

	}

}