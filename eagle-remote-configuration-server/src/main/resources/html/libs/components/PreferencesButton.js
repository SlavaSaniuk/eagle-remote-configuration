var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var PreferencesButton = function (_React$Component) {
	_inherits(PreferencesButton, _React$Component);

	function PreferencesButton(props) {
		_classCallCheck(this, PreferencesButton);

		var _this = _possibleConstructorReturn(this, (PreferencesButton.__proto__ || Object.getPrototypeOf(PreferencesButton)).call(this, props));

		_this.state = { mouse_entered: false };
		return _this;
	}

	//Enevnts handlers


	_createClass(PreferencesButton, [{
		key: "onClick",
		value: function onClick(e, url) {
			e.preventDefault();
			console.log("redirect to Settngs page; " + url.toString());
			window.location.href = url.toString();
		}
	}, {
		key: "onMouseEnter",
		value: function onMouseEnter() {
			this.setState({ mouse_entered: true });
		}
	}, {
		key: "onMouseLeave",
		value: function onMouseLeave() {
			this.setState({ mouse_entered: false });
		}

		//Component methods

	}, {
		key: "getId",
		value: function getId(number_id) {
			return "preferences_btn_" + number_id;
		}
	}, {
		key: "render",
		value: function render() {
			var _this2 = this;

			var hovered = this.state.mouse_entered;

			return React.createElement(
				"div",
				{ className: "preferences_btn", id: this.getId(this.props.btn_id),
					onClick: function onClick(e, url) {
						return _this2.onClick(e, _this2.props.pref_location);
					},
					onMouseEnter: function onMouseEnter() {
						return _this2.onMouseEnter();
					}, onMouseLeave: function onMouseLeave() {
						return _this2.onMouseLeave();
					} },
				React.createElement("img", { src: hovered ? 'img/preferences_button_hover.png' : 'img/preferences_button-min.png',
					style: preferences_btn_img
				}),
				React.createElement(
					"p",
					{ style: hovered ? preferences_btn_text_hover : preferences_btn_text },
					" ",
					this.props.btn_text,
					" "
				)
			);
		}
	}]);

	return PreferencesButton;
}(React.Component);