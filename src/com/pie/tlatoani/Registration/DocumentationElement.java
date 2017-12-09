package com.pie.tlatoani.Registration;

import ch.njol.skript.classes.ClassInfo;
import com.pie.tlatoani.Mundo;
import org.bukkit.command.CommandSender;

/**
 * Created by Tlatoani on 8/17/17.
 */
public abstract class DocumentationElement {
    public final String name;
    public final String category;
    public final String[] syntaxes;
    public final String description;
    public final String originVersion;
    public final String[] requiredPlugins;

    public enum ElementType {
        EFFECT("Effect"),
        EXPRESSION("Expression"),
        EVENT("Event"),
        TYPE("Type");

        public final String toString;

        ElementType(String toString) {
            this.toString = toString;
        }

        public String toString() {
            return toString;
        }
    }

    public abstract ElementType getType();

    public abstract void display(CommandSender sender);

    private DocumentationElement(String name, String category, String[] syntaxes, String description, String originVersion, String[] requiredPlugins) {
        this.name = name;
        this.category = category;
        this.syntaxes = syntaxes;
        this.description = description;
        this.originVersion = originVersion;
        this.requiredPlugins = requiredPlugins;
    }

    public static class Effect extends DocumentationElement {

        @Override
        public DocumentationElement.ElementType getType() {
            return ElementType.EFFECT;
        }

        @Override
        public void display(CommandSender sender) {
            sender.sendMessage(Mundo.formatMundoSKInfo(category + " Effect", name));
            sender.sendMessage(Mundo.formatMundoSKInfo("Introduced", "MundoSK " + originVersion));
            if (requiredPlugins.length > 0) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Required Plugins", String.join(" ", requiredPlugins)));
            }
            if (syntaxes.length == 1) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Syntax", syntaxes[0]));
            } else {
                sender.sendMessage(Mundo.PRIMARY_CHAT_COLOR + "Syntaxes");
                for (String syntax : syntaxes) {
                    sender.sendMessage(Mundo.ALT_CHAT_COLOR + syntax);
                }
            }
            sender.sendMessage(Mundo.formatMundoSKInfo("Description", description));
        }

        public Effect(String name, String category, String[] syntaxes, String description, String originVersion, String[] requiredPlugins) {
            super(name, category, syntaxes, description, originVersion, requiredPlugins);
        }
    }

    public static class Expression extends DocumentationElement {
        public final ClassInfo type;

        public Expression(String name, String category, String[] syntaxes, String description, String originVersion, ClassInfo type, String[] requiredPlugins) {
            super(name, category, syntaxes, description, originVersion, requiredPlugins);
            this.type = type;
        }

        @Override
        public DocumentationElement.ElementType getType() {
            return ElementType.EXPRESSION;
        }

        @Override
        public void display(CommandSender sender) {
            sender.sendMessage(Mundo.formatMundoSKInfo(category + " Expression", name));
            sender.sendMessage(Mundo.formatMundoSKInfo("Introduced", "MundoSK " + originVersion));
            if (requiredPlugins.length > 0) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Required Plugins", String.join(" ", requiredPlugins)));
            }
            sender.sendMessage(Mundo.formatMundoSKInfo("Type", type.getCodeName()));
            if (syntaxes.length == 1) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Syntax", syntaxes[0]));
            } else {
                sender.sendMessage(Mundo.PRIMARY_CHAT_COLOR + "Syntaxes");
                for (String syntax : syntaxes) {
                    sender.sendMessage(Mundo.ALT_CHAT_COLOR + syntax);
                }
            }
            sender.sendMessage(Mundo.formatMundoSKInfo("Description", description));
        }
    }

    public static class Event extends DocumentationElement {

        @Override
        public DocumentationElement.ElementType getType() {
            return ElementType.EVENT;
        }

        @Override
        public void display(CommandSender sender) {
            sender.sendMessage(Mundo.formatMundoSKInfo(category + " Event", name));
            sender.sendMessage(Mundo.formatMundoSKInfo("Introduced", "MundoSK " + originVersion));
            if (requiredPlugins.length > 0) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Required Plugins", String.join(" ", requiredPlugins)));
            }
            if (syntaxes.length == 1) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Syntax", syntaxes[0]));
            } else {
                sender.sendMessage(Mundo.PRIMARY_CHAT_COLOR + "Syntaxes");
                for (String syntax : syntaxes) {
                    sender.sendMessage(Mundo.ALT_CHAT_COLOR + syntax);
                }
            }
            sender.sendMessage(Mundo.formatMundoSKInfo("Description", description));
        }

        public Event(String name, String category, String[] syntaxes, String description, String originVersion, String[] requiredPlugins) {
            super(name, category, syntaxes, description, originVersion, requiredPlugins);
        }
    }

    public static class Type extends DocumentationElement {
        public final String[] usages;

        public Type(String name, String category, String[] syntaxes, String[] usages, String description, String originVersion, String[] requiredPlugins) {
            super(name, category, syntaxes, description, originVersion, requiredPlugins);
            this.usages = usages;
        }

        @Override
        public ElementType getType() {
            return ElementType.TYPE;
        }

        @Override
        public void display(CommandSender sender) {
            sender.sendMessage(Mundo.formatMundoSKInfo(category + " Type", name));
            sender.sendMessage(Mundo.formatMundoSKInfo("Introduced", "MundoSK " + originVersion));
            if (requiredPlugins.length > 0) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Required Plugins", String.join(" ", requiredPlugins)));
            }
            if (syntaxes.length == 1) {
                sender.sendMessage(Mundo.formatMundoSKInfo("Syntax", syntaxes[0]));
            } else {
                sender.sendMessage(Mundo.PRIMARY_CHAT_COLOR + "Syntaxes");
                for (String syntax : syntaxes) {
                    sender.sendMessage(Mundo.ALT_CHAT_COLOR + syntax);
                }
            }
            sender.sendMessage(Mundo.formatMundoSKInfo("Usages", syntaxes.length == 0 ? "Cannot be written in scripts" : String.join(", ", usages)));
            sender.sendMessage(Mundo.formatMundoSKInfo("Description", description));
        }
    }
}
