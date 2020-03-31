var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

var ProjectsMenu = function (_React$Component) {
	_inherits(ProjectsMenu, _React$Component);

	function ProjectsMenu(props) {
		_classCallCheck(this, ProjectsMenu);

		var _this = _possibleConstructorReturn(this, (ProjectsMenu.__proto__ || Object.getPrototypeOf(ProjectsMenu)).call(this, props));

		_this.state = { opened: false };
		return _this;
	}

	_createClass(ProjectsMenu, [{
		key: "onClick",
		value: function onClick(e) {
			e.preventDefault();
			console.log("Menu toggle clicked;");
			var isOpened = this.state.opened;
			console.log("Menu toggle state: " + isOpened.toString());
			isOpened ? this.closeMenu() : this.displayMenu();
		}
	}, {
		key: "displayMenu",
		value: function displayMenu() {
			this.setState({ opened: true });
			this.refs.menu_content.unwrapMenu();
		}
	}, {
		key: "closeMenu",
		value: function closeMenu() {
			this.setState({ opened: false });
			this.refs.menu_content.wrapMenu();
		}
	}, {
		key: "render",
		value: function render() {
			var _this2 = this;

			var isOpened = this.state.opened;

			return React.createElement(
				"div",
				null,
				React.createElement(
					"div",
					{ style: projects_menu_title, onClick: function onClick(e) {
							return _this2.onClick(e);
						} },
					React.createElement("img", { src: "img/menu_toggle.png", style: isOpened ? projects_menu_title_icon_opened : projects_menu_title_icon }),
					React.createElement(
						"p",
						{ style: projects_menu_title_text },
						" ",
						this.props.project_menu_title,
						" "
					)
				),
				React.createElement(ProjectsMenuContent, { ref: "menu_content", NO_CONTENT_MSG: this.props.project_menu_content_NO_CONTENT_MSG,
					content_add_btn_title: this.props.project_menu_content_add_btn_title })
			);
		}
	}]);

	return ProjectsMenu;
}(React.Component);